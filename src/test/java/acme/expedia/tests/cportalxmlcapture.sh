#!/bin/bash

# ######################################
# This shell script should be deployed
# into the fuse user home directory on
# the ESB server and made executable
# ######################################

# VARIABLES
homedir=`pwd`
logger=logfile.txt
logdir=/opt/fuse/data/log/
logfile=fuseesb-DEBUG.log
b=0

# DEBUG
#echo $homedir
#echo $logdir$logfile
#echo $homedir/$logger

# Delete previous logger file (if one exists)
rm -f $homedir/$logger
# Create a new logger file of size zero bytes
touch $homedir/$logger

# Invoke the tail on the fuse log to trap the exml payload and output it to the logger file
tail -f $logdir$logfile | grep Payload | grep CUSTOMER_PORTAL | grep ClaimNotification > $homedir/$logger&
# Capture the pid of the tail so we can kill it later
tailpid=$!

# loop in here until logger file is > 0
# then return the contents in a string`
chk=0
while [ $chk -eq 0 ]
do
#echo "validating"
if [ -s $homedir/$logger ]
then
 chk=1
else
  chk=0
fi
# DEBUG
#echo $chk
done

# File is greater than 0, now kill the job as it si running in bg mode
kill $tailpid

# Cat the require text back from the putty session
cat $logger