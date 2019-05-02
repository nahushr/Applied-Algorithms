# -*- coding: utf-8 -*-
"""
Created on Thu Mar 28 13:13:20 2019

@author: tanvi
"""

def lcs(a, b):
    n = len(a)
    m = len(b)
    #opt = [n+1][m+1]
    opt = []
    for i in range(n+1):
        opt.append([])
        for j in range(m+1):
            opt[i].append(0)    

    match = 0
    i_miss = 0
    j_miss = 0

    for i in range(1,n+1):
        for j in range(1,m+1):
            if a[i-1]==b[j-1]:
                match = opt[i-1][j-1]+1
            else:
                match = opt[i-1][j-1]
            i_miss = opt[i-1][j]
            j_miss = opt[i][j-1]
            opt[i][j] = max(match, max(i_miss, j_miss))
    print opt        
           
    seq = ''
    i = n
    j = m
    while(i > 0 and j > 0):
        if (a[i-1]==b[j-1] and opt[i][j]==opt[i-1][j-1]+1): #{  // match case
            seq+=a[i-1]
            i-=1
            j-=1
        elif (opt[i][j] == opt[i-1][j]): #{  // i miss case
            i-=1
        else:
            j-=1  #// j miss case
        
    return seq[::-1]
    

ans = lcs('ACCGGTCGAGTGCGCGGAAGCCGGCCGAA', 'GTCGTTCGGAATGCCGTTGCTCTGTAAA')
print ans
print len(ans)