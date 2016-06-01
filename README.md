# LeetCode Extension

## 1 Description

This is an extension for chrome.

[Download in chrome web store]
(https://chrome.google.com/webstore/detail/leetcode-extension/eomonjnamkjeclchgkdchpabkllmbofp)

Source Code: <https://github.com/binarylu/leetcode-ext>

In source code,  

`leetcode-ext` folder is the source code of chrome extension.

`server` folder is the source code for crawling the problem tags from leetcode.com.

## 2 Usage

There are six major functions:

1. Show your progress, in different difficulities, in different company tags and in different tags.
2. Hide the acceptance and difficulty.
3. Hide the locked problems.
4. Commit your code to your GitHub.
5. After running or submitting code, disable the button for 10 seconds to avoid the error that submitting too frequently.
6. Show the content of locked problems and the problem list of each company tag.

For `1`, `2` and `5`, they can be turned on / off in extension option page.

For `3`, there is checkbox in problem list page and tag page.

For `4`, you can login your github account in option page by OAuth. After you login, input the repository name, __*not the URL*__.  
If the repository you type in does not exist, it will be created. Otherwise, just connect to the existing repository.

For `6`, to see the content of locked problem, click the green icon at the right of each locked problem.  
If you are not a subscriber, the linke of each company tag will be changed, there will appear a modal showing the problem list after you click the company tag.  
In problem page, the company tag button will appear even if you are not a subscriber.  

## 3 Acknowledge

This project is just for study, if you can afford, please subscrib to support <https://leetcode.com>.
