let arr: any[] | undefined = [];

console.log(Boolean(arr));
console.log(Boolean(arr?.length));
console.log(arr?.length > 0);

if (1 == 1) {
  arr = undefined;
}

console.log(Boolean(arr?.length));