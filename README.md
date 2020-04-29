# Getting Started

## Downloads
- downloaded IntelliJ IDEA
- registered with github

## Mac
- created shortcut for terminal
- created shortcut for IntelliJ IDEA

## Install homebrew
Found this command on the homebrew website
`/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"`

## Install stuff
`brew install git`
`brew install maven`

## Push this project into github
```bash
cd ~/IdeaProjects/hello
git init
git add --all
git remote add origin https://github.com/BadWolfKitty42/hello.git
git push -u origin master
```

## Build project
`mvn package`

## References
- https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html

## Hello world specification
- read a file name from the command line
- read the greeting target from that file
- compose a greeting for that target
- write that greeting to the console