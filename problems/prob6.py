s_key,l_key = raw_input().split(' ')
s_key = int(s_key)
l_key = int(l_key)
t= int(raw_input())
keys = []
lst = raw_input()
keys = list(map(int,lst.split(' ')))
flag = 0
sec = 0
for i in range(0,t):
    sec = sec + 1
    s_key = s_key * keys[i]
    if s_key == l_key:
        flag = 1
        break
if flag == 1 :
    print sec
else:
    print '-1'
