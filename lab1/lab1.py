def minnumber(arr ,begin, end, n):
    min,file=99999999999999999999999999,open("minfile.txt","a+") ##a+ is appending at the end of the file if the file exists
    for i in range(begin,end+1):
        if arr[i]<min: min=arr[i]
    file.write(str(min)+'\n')
##main
file,arr,counter=open("applied_algo/lab1_minNumber_test.txt","r"),[],0
for line in file:
    if counter!=0:arr.append(int(line))
    counter+=1
minnumber(arr,0,99,100),minnumber(arr,100,399,300),minnumber(arr,400,999,600)

