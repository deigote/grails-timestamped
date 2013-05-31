#!/bin/bash

DEST="$HOME/Projects/personal/github.io/grails-timestamped"
grails doc && \
cp -R target/docs/* "$DEST" && \
cd "$DEST" && \
git add . && \
git commit . -m 'Updated grails-timestamped documentation' && \
git push
