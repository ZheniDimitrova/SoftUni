function reverseArray (num, inputArr) {
    let newArr = inputArr.splice(0, num);
    console.log(newArr.reverse().join(" "));
}
reverseArray(3,[2,3,4,5,6,7]);