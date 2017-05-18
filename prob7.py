t = int(raw_input())
n = []
lines = []
for i in range(0,t):
    n.append(int(raw_input()))
    lines.append(raw_input())
for i in range(0,t):
    lst = list(map(int,lines[i].split(' ')))
    flag = 0
    for j in range(0,n[i]):
        if j != lst.index(j+1):
            flag = 1
    if flag == 0:
        print "inverse"
    else:
        print "not inverse"
        
