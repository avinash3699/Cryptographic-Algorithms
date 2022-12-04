def split_words(pt):
    words=[]
    i=0
    while i<len(pt):
        if i+1==len(pt) or pt[i]==pt[i+1]:
            words.append(pt[i]+'x')
            i+=1
        else:
            words.append(pt[i]+pt[i+1])
            i+=2
    return words
def find_coords(a,b):
    global matrix
    x1=y1=x2=y2=-1
    for i in range(5):
        for j in range(5):
            if matrix[i][j]==a:
                x1,y1=i,j 
            elif matrix[i][j]==b:
                x2,y2=i,j 
    return[x1,y1,x2,y2]

plain_text = input("Enter text: ").strip()
key = input("Enter key: ").strip()
matrix=[['' for i in range(5)]for i in range(5)]
other_alpha=[chr(i) for i in range(ord('a'),ord('z')+1) if chr(i) not in key and chr(i)!='j']
key+=''.join(other_alpha)
count=0
for i in range(5):
    for j in range(5):
        matrix[i][j]=key[count]
        count+=1 
word_split = split_words(plain_text)
print(word_split)
enc_text=''
for word in word_split:
    x1,y1,x2,y2=find_coords(word[0],word[1])
    if x1==x2:
        enc_text+=matrix[x1][(y1+1)%5]+matrix[x2][(y2+1)%5]
    elif y1==y2:
        enc_text+=matrix[(x1+1)%5][y1]+matrix[(x2+1)%5][y2]
    else:
        enc_text+=matrix[x1][y2]+matrix[x2][y1]
print(enc_text)
