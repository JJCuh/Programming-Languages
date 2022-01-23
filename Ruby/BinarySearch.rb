def binary_search(array, item)
    left = 0
    right = array.length - 1
    while left <= right
        m = (left + right) / 2
        if array[m] < item
            left = m + 1
        elsif array[m] > item
            right = m - 1
        else
            return "#{item} found at position #{m}"
        end
    end
    return "#{item} not found in this array"
end

array = [1,2,3,4,5]
puts binary_search(array,0)
puts binary_search(array,1)
puts binary_search(array,2)
puts binary_search(array,3)
puts binary_search(array,4)
puts binary_search(array,5)
puts binary_search(array,6)
