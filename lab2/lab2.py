##selection sorting
def minnum(arr, begin, end):
    minindex=begin
    for i in range(begin+1, end):
        if(arr[i]<arr[minindex]):minindex=i
    return minindex
def swap(arr,i,j):
    arr[i],arr[j] = arr[j], arr[i]
def selectionsort(arr):
    for i in range(len(arr)-1):
        minindex=minnum(arr,i,len(arr))
        swap(arr,i,minindex)
    print (arr)
##selection sorting

##insertion sorting
def insertsort(arr):
    for i in range(0,len(arr)):
        j=i
        while(j>0 and (arr[j-1] > arr[j])):
            swap(arr,j-1,j)
            j=j-1
    print (arr)
##insertion sorting

##insertion sorting
##main
file,arr,counter=open("lab2_test_sorting2.txt","r"),[],0
for line in file:
    if counter!=0:arr.append(int(line))
    counter+=1
print ("Selection Sort:")
selectionsort(arr)
print("Insertion Sort:")
insertsort(arr)
