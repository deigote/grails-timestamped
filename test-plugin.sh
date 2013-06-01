git submodule update --init && \
cd TimestampedDemo/ && \
git pull origin master && \
cd .. && \
grails package-plugin && \
cp target/grails-plugin-timestamped-*.jar TimestampedDemo/lib/ && \
cd TimestampedDemo/ && \
./test.sh 
git checkout -- lib/grails-plugin-timestamped-*.jar 
