#!bin bash
javapath=`which java`

if [ -z != $javapath ]
then
echo "java installed"
else
echo " install java and continue, exiting...... "
exit
fi

mavenpath=`which mvn`

if [ -z != $mavenpath ]
then
echo "maven installed"
else
echo " install maven and continue, exiting...... "
exit
fi
rm -r target
echo "stopping old job "
job="job.pid"
if [ -f "$job" ]
then
kill -9 `cat job.pid`
fi
echo "building the project, might take some time"

mvn clean install > build.logs

echo "running the job"

if [ "$CONFIG_TYPE" == "STAGE" ] || [ "$CONFIG_TYPE" == "PROD" ]
then
java -Xmx10000M -Xms256M  -jar target/springDemo.jar  &
echo $! > job.pid
else
java -Xmx10000M -Xms256M -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=6006  -jar target/springDemo.jar 1>>build.logs 2>>build.logs &
fi

