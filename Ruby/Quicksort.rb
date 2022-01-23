def partition(array, p, r)
    pivot = array[r]
    while (p < r)
        while (array[p] < pivot)
            p+=1
        end
        while array[r] > pivot
            r-=1
        end
        if array[p] == array[r]
            p+=1
        elsif p < r
            tmp = array[p]
            array[p] = array[r]
            array[r] = tmp
        end
    end
    return r
end

def quicksort(array, p, r)
    if (p < r)
        j = partition(array, p, r)
        quicksort(array, p, j-1)
        quicksort(array, j+1, r)
    end
end

#Main:
array = [500, 700, 800, 100, 300, 200, 900, 400, 1000, 600]

print "Input: "
for i in array
  print i.to_s + " "
end
puts

quicksort(array, 0, 9)

puts(array.pop.to_s)

print "Output: "
for i in array
  print i.to_s + " "
end
