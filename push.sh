#!/bin/zsh

MSG=${1:-"update data"}

git add .
git commit -m "$MSG"
git push origin dev