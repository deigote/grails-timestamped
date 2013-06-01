#!/bin/bash
git submodule update --init && \
cd maven-deployer && \
git pull origin master && \
cd .. && \
maven-deployer/deploy.sh . com.deigote.grails-plugins timestamped $HOME/Projects/personal/github.io/grails-timestamped/maven/releases/ && \
cd $HOME/Projects/personal/github.io/grails-timestamped/maven/releases && \
git add .  && git commit -m 'Updated maven for grails-timestamped' && git push origin master


