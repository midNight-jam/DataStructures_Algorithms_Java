def hamming_dist(a,b):
  #get the no of non similar bits via XOR and count 1 set bits in the diff
  diff = a ^ b
  hammDist = 0
  while(diff > 0):
    hammDist += diff & 1
    diff = diff >> 1
  return hammDist

if __name__ == '__main__':
  print(hamming_dist(0,7))