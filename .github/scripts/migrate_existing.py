
from pathlib import Path
import re
import time
import requests

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


def get_topic(problem_folder, session):
    slug = re.sub(
        r"^\d+-", "", problem_folder.name, count=1
    )

    response = session.post(
        API,
        json={
            "query": QUERY,
            "variables": {"titleSlug": slug},
        },
        timeout=30,
    )
    response.raise_for_status()
    data = response.json()

    if data.get("errors") or not data.get("data"):
        raise RuntimeError(f"LeetCode lookup failed: {slug}")

    question = data["data"].get("question")
    if not question:
        raise RuntimeError(f"Problem not found: {slug}")

    tags = question.get("topicTags", [])
    if not tags:
        return "Other"

    first_tag = tags[0]["name"]
    return TOPIC_MAP.get(
        first_tag,
        re.sub(r"[^A-Za-z0-9]+", "-", first_tag).strip("-"),
    )


def main():
    session = requests.Session()
    session.headers.update({"User-Agent": "Mozilla/5.0"})

    # Find historical Java solutions anywhere in the repository.
    java_files = list(Path(".").rglob("solution.java"))

    problems = sorted(
        {file.parent for file in java_files},
        key=lambda path: str(path),
    )

    # Only migrate folders from the old malformed directory.
    old_problems = [
        folder for folder in problems
        if "%difficulty%" in folder.as_posix()
    ]

    if not old_problems:
        print("No Java solutions found in the old folder.")
        return

    moves = []

    for folder in old_problems:
        topic = get_topic(folder, session)
        destination = Path(topic) / folder.name

        if destination.exists():
            raise RuntimeError(
                f"Destination already exists: {destination}. "
                "No folders have been moved."
            )

        moves.append((folder, destination))
        print(f"Planned: {folder} -> {destination}")
        time.sleep(0.2)

    # Validate every destination before moving any folder.
    for source, destination in moves:
        if destination.exists():
            raise RuntimeError(
                f"Destination conflict: {destination}"
            )

    for source, destination in moves:
        destination.parent.mkdir(parents=True, exist_ok=True)
        source.rename(destination)

    print(f"Successfully migrated {len(moves)} problem folders.")


if __name__ == "__main__":
    main()
