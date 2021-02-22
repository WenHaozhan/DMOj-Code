#unfinished, time fail
def mergesort(arr,start,end):
    if((end-start)>=1):
        mid = (start+end)//2
        mergesort(arr,start,mid)
        mergesort(arr,mid+1,end)
        merge(arr, start, mid,end)

def merge(arr,start, mid , end):
    l = 0
    r = 0
    left = arr[start:mid+1].copy()
    right = arr[mid+1:end+1].copy()
    for i in range (start, end+1):
        if(r == len(right) or (l< len(left) and left[l]<=right[r] )):
            arr[i] = (left[l])
            l+=1
        else:
            arr[i] = (right[r])
            r+=1
    
x = int(input())
arr = []
for i in range(x):
    temp = int(input())
    arr.append(temp)
mergesort(arr,0,len(arr)-1)
for i in arr:
    print (i)
