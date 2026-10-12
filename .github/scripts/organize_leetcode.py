
from pathlib import Path
import re
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
    if not question:
        raise RuntimeError(f"Problem not found: {slug}")

    tags = question.get("topicTags", [])
    if not tags:
        return "Other"

    tag = tags[0]["name"]
    return TOPIC_MAP.get(
        tag,
        re.sub(r"[^A-Za-z0-9]+", "-", tag).strip("-"),
    )


def main():
    if not STAGING.is_dir():
        print("No temp_solutions directory found; nothing to organize.")
        return

    session = requests.Session()
    session.headers.update({"User-Agent": "Mozilla/5.0"})

    moves = []

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
            raise RuntimeError(
                f"Destination already exists: {destination}. "
                "Nothing has been moved yet."
            )

        moves.append((folder, destination))
        time.sleep(0.2)

    # Validate all destinations before moving any folders.
    for source, destination in moves:
        destination.parent.mkdir(parents=True, exist_ok=True)
        source.rename(destination)

    try:
        STAGING.rmdir()
    except OSError:
        pass

    print(f"Organized {len(moves)} Java problem folders.")


if __name__ == "__main__":
    main()
