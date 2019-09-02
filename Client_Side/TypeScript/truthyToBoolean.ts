function anyTruthy(s: string, n: number, o: object | null, arr?: any[]) {
  const result: boolean = !!(s || n || o || arr);
  console.info(`'${s}'`, n,  o,  arr, ": any truthy?", result);
}

function allTruthy(s: string, n: number, o: object | null, arr?: any[]) {
  const result: boolean = !!(s && n && o && arr);
  console.info(`'${s}'`, n,  o,  arr, ": all truthy?", result);
}

allTruthy("foo", 42, {}, []);
allTruthy("", 42, {}, []);
allTruthy("foo", 42, null, []);
allTruthy("foo", 0, {}, []);
allTruthy("foo", Infinity, {}, []);
allTruthy("foo", 42, {});
allTruthy("foo", NaN, {}, []);

anyTruthy("foo", 42, {}, []);
anyTruthy("", NaN, null);