import random

def ran_func():
    for i in range(10):
        print (random.uniform(0,1))

def swap(arr,i,j):
    temp=arr[i]
    arr[i]=arr[j]
    arr[j]=temp

def partition(arr,low,high):
    i=low-1
    pivot=arr[high]
    for j in range(low, high):
        if(arr[j]<=pivot):
            i=i+1
            swap(arr,i,j)
    swap(arr,high,i+1)
    return i+1

def quickSort(arr,low,high):
    if(low<high):
        index=random.randint(low,high-1)
        swap(arr,low,index)
        p=partition(arr,low,high)
        quickSort(arr,low,p-1)
        quickSort(arr,p+1,high)

file,arr,counter=open("applied_algo/lab4_test_sorting.txt","r"),[],0
for line in file:
    if counter!=0:arr.append(int(line))
    counter+=1

print("Random Function:-")
ran_func()
print("QuickSort:- ")
quickSort(arr,0,len(arr)-1)
print(arr)

