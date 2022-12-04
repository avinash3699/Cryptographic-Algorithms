def matrixgen(k):
    key=k 
    for i in range(97,123):
        if chr(i) not in key and chr(i)!='i':
            if chr(i)=='j' and 'i' in key:
                continue
            key+=chr(i)
    matrix=[]
    for i in range(0,len(key),5):
        row=[]
        for j in range(i,i+5):
            if key[j]=='i' or key[j]=='j':
                row.append('i')
            else:
                row.append(key[j])
        matrix.append(row)
    return matrix

def plaintextgen(pt):
    for i in range(0,len(pt),2):
        if len(pt)%2==1 and i==len(pt)-1:
            if pt[i]=="x":
                pt+="y"
            else:
                pt+="x"
        elif pt[i]==pt[i+1]:
            if pt[i]=='x':
                pt=pt[:i+1]+'y'+pt[i+1:]
            else:
                pt=pt[:i+1]+'x'+pt[i+1:]
    return pt 

def swaps(matrix,pt):
    ciphertext=""
    for i in range(0,len(pt)-1,2):
        for j in range(5):
            for k in range(5):
                if pt[i] in matrix[j][k]:
                    r1,c1=j,k
                elif pt[i+1] in matrix[j][k]:
                    r2,c2=j,k
        if r1==r2:
            ciphertext+=(matrix[r1][(c1+1)%5]+matrix[r2][(c2+1)%5])
        elif c1==c2:
            ciphertext+=(matrix[(r1+1)%5][c1]+matrix[(r2+1)%5][c2])
        else:
            ciphertext+=(matrix[r1][c2]+matrix[r2][c1])
    return ciphertext

plaintext=input("Enter Plaintext: ").strip()
key=input("Enter key: ").strip()
k=matrixgen(key)
pt=plaintextgen(plaintext)
print("The Ciphertext is:",swaps(k,pt))
