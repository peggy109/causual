#!/bin/bash
echo "FUNC: while read l"
while read l 
do 
echo "line :"$l
done < $1

echo "FUNC: while line"
while l=$(line)
do 
echo "line :"$l
done < $1

echo "FUNC: cat while read l"
cat $1 | while read l 
do 
echo "line :"$l
done

echo "FUNC: cat while line"
cat $1 | while l=$(line) 
do 
echo "line :"$l
done

echo "FUNC: for l in cat file"
for l in `cat $1`
do
echo "line:"$l"(end)"
done

echo "FUNC: for l in file"
for l in $(cat $1)
do
echo "line:"$l"(end)"
done

