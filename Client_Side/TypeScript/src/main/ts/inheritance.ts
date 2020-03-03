abstract class Animal {
  playWith() {
    this.talk();
  }

  talk() {
    console.log('Animal.talk()')
  }
}

class Cat extends Animal {
  talk() {
    console.log('Meow')
  }
}

const garfield = new Cat();
garfield.playWith();