# Codex Instructions

Whenever the user pastes a LeetCode solution, update this repository using the existing structure and style.

The user's submitted code must be preserved exactly. Do not modify, refactor, rename, or reformat the code they provide. The only allowed additions to the submitted code are the solution type and time/space complexity. Add the time and space complexity for every approach included in the code file, including commented alternatives. Make all other documentation or repository-tracker updates separately when required.

## Workflow

1. Identify the problem number and problem name from the user's message.
2. Convert the problem name into the existing folder style:
   - Lowercase words.
   - Use hyphens between words.
   - Example: `94. Binary Tree Inorder Traversal` becomes `binary-tree-inorder-traversal`.
3. If the folder already exists:
   - Update the existing solution file.
   - Preserve previous approaches by renaming them clearly, such as `_recursive`, `_bruteForce`, `_optimal`, `_iterative`, or `_iterativeTwoStacks`.
   - Keep the user's latest submitted solution as the active LeetCode function when appropriate.
   - If the pasted solution is in a different language than the existing file, create a new language-specific file in the same folder instead of changing the existing solution file.
   - Example: if `binary-tree-postorder-traversal.js` already exists and the user pastes Java code, create `binary-tree-postorder-traversal.java`.
   - In this different-language case, do not update the existing language file and do not update the existing problem `README.md` unless the user explicitly asks.
4. If the folder does not exist:
   - Create the folder.
   - Create `<folder-name>.js`.
   - Create `README.md`.
5. Keep all approaches in the solution file:
   - Brute force.
   - Better approach.
   - Optimal approach.
   - Recursive or iterative variants when provided.
   - Multiple stack/window/map approaches when provided.
   - If the file you are given has only one solution approach (iterative **or** recursive, but not both), do **not** add the other approach on your own. Only add the missing variant when the user explicitly asks for it.
6. Match the repository's current solution style:
   - Use LeetCode JSDoc comments.
   - Use clear comment headers for each approach.
   - Keep inactive alternatives as named functions or commented sections when that matches nearby files.
   - **In the code file**, only include a brief one-line description of the approach and the time/space complexity. Do NOT write step-by-step algorithm explanations inside the code file.
   - **In the README**, write the full step-by-step algorithm explanation for each approach. The README is the place for detailed "how it works" content.
7. Always create or update the problem `README.md`:
   - Problem title.
   - LeetCode problem link.
   - Problem description.
   - Example.
   - Explanation for each approach.
   - Time and space complexity.
8. After every submitted problem, always check and update the root `README.md` progress tracker:
   - Add the problem if it is missing.
   - Keep its number, title, folder link, and difficulty accurate.
   - Do this whether the problem folder is new or already exists.
9. Do not remove unrelated user changes.
10. After the solution and documentation are complete:
    - Stage all files created or modified for the current problem (solution file, problem `README.md`, and the updated root `README.md` tracker) in a **single commit**.
    - Commit with this message format:

```text
solved leetcode problem No. <problem-number> <problem-title>
```

    - Example:

```text
solved leetcode problem No. 124 Binary Tree Maximum Path Sum
```

    - **Do NOT push automatically.** After committing, always ask the user explicitly: "Should I push this commit to GitHub?" and wait for confirmation before running `git push`.
    - Do not include unrelated or previously untracked files in the commit.
