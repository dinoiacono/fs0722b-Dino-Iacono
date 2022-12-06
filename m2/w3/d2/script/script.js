class person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
}

var p1 = new person("Paolo", 30);
var p2 = new person("Mario", 20);
var p3 = new person("Giovanni", 30);

function conforntaEtà() {
  if (p1.age > p2.age) {
    console.log(`${p1.name} è più grande di ${p2.name}`);
  } else if (p1.age === p2.age) {
    console.log(`${p1.name} e ${p2.name} hanno la stessa età`);
  } else {
    console.log(`${p2.name} è più grande di ${p1.name}`);
  }

  if (p3.age > p2.age) {
    console.log(`${p3.name} è più grande di ${p2.name}`);
  } else if (p3.age === p2.age) {
    console.log(`${p3.name} e ${p2.name} hanno la stessa età`);
  } else {
    console.log(`${p2.name} è più grande di ${p3.name}`);
  }

  if (p1.age > p3.age) {
    console.log(`${p1.name} è più grande di ${p3.name}`);
  } else if (p1.age === p3.age) {
    console.log(`${p1.name} e ${p3.name} hanno la stessa età`);
  } else {
    console.log(`${p3.name} è più grande di ${p1.name}`);
  }
}
conforntaEtà();
