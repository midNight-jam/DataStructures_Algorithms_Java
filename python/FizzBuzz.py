def fizzBuzz(n):
  res = []
  for i in range(1,n+1):
    if(i % 5 ==0 and i % 3 == 0):
      res.append("FizzBuzz")
    elif(i % 5 ==0):
      res.append("Buzz")
    elif (i % 3 == 0):
      res.append("Fizz")
    else:
      res.append('{}'.format(i))

  return res

def fizzBuzzCompact(n):
  return ['Fizz' * (not i % 3) +'Buzz' * (not i % 5) or str(i) for i in range(1,n+1)]

def main():
  k = 9
  # print( (not k % 3) + 1)
  for i in fizzBuzzCompact(15):
    print i

if __name__ == '__main__':
  main()