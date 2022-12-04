plaintext=input("Enter the plaintext: ").strip()
key=list(map(int,input("Enter the key: ").split()))
x=max(key)
ptmatrix=[]
for i in range(0,len(plaintext),x):
    ptmatrix.append(plaintext[i:i+x].ljust(x,'x'))
ptmatrix=[''.join(list(i)) for i in zip(*ptmatrix)]
for i in range(1,x+1):
    print(ptmatrix[key.index(i)],end="")





