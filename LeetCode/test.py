nums = [1,1]
def firstMissingPositive(nums):
    n = len(nums)
    for i in range(n):
        while 1 <= nums[i] <= n and nums[nums[i] - 1] != nums[i]:
            nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]
            print(nums)
    # print(nums)
    i = 0
    while i < n and  i + 1 == nums[i]:
        i += 1
    return i + 1

firstMissingPositive(nums)