
from pathlib import Path
import re
import shutil
import time
import requests

STAGING = Path("temp_solutions")
API = "https://leetcode.com/graphql"

QUERY = """
query questionTitle($titleSlug: String!) {
  question(titleSlug: $titleSlug) {
    topicTags {
      name
    }
  }
}
"""

TOPIC_MAP = {
    "Array": "Arrays",
    "String": "Strings",
    "Hash Table": "Hashmaps",
    "Linked List": "LinkedList",
    "Binary Search": "BinarySearch",
    "Dynamic Programming": "DynamicProgramming",
    "Two Pointers": "TwoPointers",
    "Sliding Window": "SlidingWindow",
    "Binary Tree": "Trees",
    "Binary Search Tree": "Trees",
    "Depth-First Search": "Graphs",
    "Breadth-First Search": "Graphs",
    "Graph": "Graphs",
    "Union Find": "Graphs",
    "Stack": "Stack",
    "Queue": "Queue",
    "Heap (Priority Queue)": "Heap",
    "Backtracking": "Backtracking",
    "Greedy": "Greedy",
    "Sorting": "Sorting",
    "Trie": "Trie",
    "Matrix": "Matrix",
    "Prefix Sum": "PrefixSum",
    "Bit Manipulation": "BitManipulation",
    "Math": "Math",
}


def slug_from_folder(name):
    return re.sub(r"^\d+-", "", name, count=1)


def get_topic(folder_name, session):
    slug = slug_from_folder(folder_name)

    response = session.post(
        API,
        json={
            "query": QUERY,
            "variables": {"titleSlug": slug},
        },
        timeout=20,
    )
    response.raise_for_status()
    data = response.json()

    if data.get("errors") or not data.get("data"):
        raise RuntimeError(f"Metadata lookup failed: {slug}")

    question = data["data"].get("question")

    if not question or not question.get("topicTags"):
        print(f"WARNING: Could not retrieve topic metadata for: {slug}")
        return "Other"

    tags = question.get("topicTags", [])
    if not tags:
        return "Other"

    tag = tags[0]["name"]
    return TOPIC_MAP.get(
        tag,
        re.sub(r"[^A-Za-z0-9]+", "-", tag).strip("-"),
    )


def transfer_folder(source, destination):
    """Move new files without overwriting existing files."""
    conflicts = []

    destination.mkdir(parents=True, exist_ok=True)

    for item in source.rglob("*"):
        if not item.is_file():
            continue

        relative = item.relative_to(source)
        target = destination / relative
        target.parent.mkdir(parents=True, exist_ok=True)

        if target.exists():
            if item.read_bytes() == target.read_bytes():
                print(f"Duplicate file skipped: {target}")
            else:
                print(f"CONFLICT: preserved both copies separately: {item}")
                conflicts.append(item)
            continue

        shutil.copy2(item, target)
        print(f"Added: {target}")

    if conflicts:
        print(
            f"WARNING: {len(conflicts)} conflicting file(s) remain "
            f"in {source}; review them before deleting anything."
        )
        return False

    shutil.rmtree(source)
    return True


def main():
    if not STAGING.is_dir():
        print("No temp_solutions directory found; nothing to organize.")
        return

    session = requests.Session()
    session.headers.update({"User-Agent": "Mozilla/5.0"})

    for folder in sorted(STAGING.iterdir()):
        if not folder.is_dir():
            continue

        java_files = list(folder.rglob("*.java"))
        if not java_files:
            print(f"Leaving non-Java folder untouched: {folder.name}")
            continue

        topic = get_topic(folder.name, session)
        destination = Path(topic) / folder.name

        if destination.exists():
            print(f"Existing problem folder found: {destination}")
            transfer_folder(folder, destination)
        else:
            destination.parent.mkdir(parents=True, exist_ok=True)
            shutil.move(str(folder), str(destination))
            print(f"Organized: {destination}")

        time.sleep(0.2)

    try:
        STAGING.rmdir()
    except OSError:
        pass


if __name__ == "__main__":
    main()
