
from pathlib import Path
import re
import time
import requests

API = "https://leetcode.com/graphql"
OLD_MARKER = "%difficulty%"

QUERY = """
query questionTitle($titleSlug: String!) {
  question(titleSlug: $titleSlug) {
    topicTags { name }
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

PRIORITY = [
    "Linked List",
    "Binary Tree",
    "Binary Search Tree",
    "Graph",
    "Depth-First Search",
    "Breadth-First Search",
    "Trie",
    "Heap (Priority Queue)",
    "Stack",
    "Queue",
    "Dynamic Programming",
    "Backtracking",
    "Sliding Window",
    "Two Pointers",
    "Binary Search",
    "Union Find",
    "Hash Table",
    "String",
    "Array",
    "Matrix",
    "Prefix Sum",
    "Bit Manipulation",
    "Greedy",
    "Sorting",
    "Math",
]


def get_topic(problem_folder, session):
    slug = re.sub(
        r"^\d+-", "", problem_folder.name, count=1
    )
    slug = re.sub(r"-+", "-", slug).strip("-")

    for attempt in range(3):
        try:
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

            question = (data.get("data") or {}).get("question")
            if question:
                tags = question.get("topicTags", [])
                names = {tag["name"] for tag in tags}

                for name in PRIORITY:
                    if name in names:
                        return TOPIC_MAP[name]

                if tags:
                    name = tags[0]["name"]
                    return TOPIC_MAP.get(name, "Other")

                return "Other"

        except (requests.RequestException, ValueError):
            pass

        time.sleep(1 + attempt)

    print(f"  Metadata unavailable; placing in Other: {slug}")
    return "Other"


def main():
    # Find original problems recursively, not just the first directory level.
    java_files = Path(".").rglob("solution.java")

    problems = sorted({
        file.parent
        for file in java_files
        if OLD_MARKER in file.as_posix()
    })

    if not problems:
        raise RuntimeError(
            "No original Java solutions found under the old folder."
        )

    print(f"Found {len(problems)} original Java problem folders.")

    session = requests.Session()
    session.headers.update({"User-Agent": "Mozilla/5.0"})

    moves = []

    for index, folder in enumerate(problems, start=1):
        topic = get_topic(folder, session)
        destination = Path(topic) / folder.name

        if destination.exists():
            raise RuntimeError(
                f"Destination conflict: {destination}. "
                "No folders have been moved."
            )

        moves.append((folder, destination))
        print(
            f"[{index}/{len(problems)}] "
            f"{folder.name} -> {topic}"
        )
        time.sleep(0.15)

    print(f"\nMigration plan contains {len(moves)} folders.")
    print("Review the topic assignments above.")

    confirmation = input(
        '\nType MOVE to apply these changes, or anything else to cancel: '
    ).strip()

    if confirmation != "MOVE":
        print("Cancelled. No folders were moved.")
        return

    # Recheck every destination before making any changes.
    for _, destination in moves:
        if destination.exists():
            raise RuntimeError(
                f"Destination conflict: {destination}. "
                "Resolve it before retrying."
            )

    for source, destination in moves:
        destination.parent.mkdir(parents=True, exist_ok=True)
        source.rename(destination)

    print(f"\nSuccessfully moved {len(moves)} problem folders.")


if __name__ == "__main__":
    main()
