s = "0"
q = int(raw_input())
lst = []
for j in range(0,q):
    lst.append(int(raw_input()))
while len(s) <= 1000:
    t = ""
    for i in range(0,len(s)):
        if s[i] == "0" :
            t = t + "1"
        if s[i] == "1" :
            t = t + "0"
    s = s + t
for j in range(0,q):
    print s[lst[j]]
