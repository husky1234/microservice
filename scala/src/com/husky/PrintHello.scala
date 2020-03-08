package com.husky

object PrintHello {

  def main(args: Array[String]): Unit = {
    var name = "yinjie"
    var age = 24
    var sex = "m"
    print("nihao\n")
    printf("name = %s, age = %d, sex = %s\n",name,age,sex)
    printf(s"name = ${name},age = ${age},sex = ${sex}\n")
  }

}
