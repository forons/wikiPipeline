#! /bin/bash

dirs=( "../desc/Iyas" )

MAIN=org.apache.uima.tools.jcasgen.Jg

for dir in "${dirs[@]}"
do
    for desc in ${dir}/*.xml
    do
        echo "Processing $desc..."
        "$UIMA_HOME/bin/runUimaClass.sh" $MAIN -jcasgeninput "$desc" -jcasgenoutput "../src/test/java"
    done
done
