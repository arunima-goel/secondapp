import org.mycompany.Person

class BootStrap {

    def init = { servletContext ->
        if (!Person.count()) {
            new Person(firstName: "fname1", lastName: "lname1", age: 10).save(failOnError: true)
            new Person(firstName: "fname2", lastName: "lname2", age: 11).save(failOnError: true)
            new Person(firstName: "fname3", lastName: "lname3", age: 12).save(failOnError: true)
            new Person(firstName: "fname4", lastName: "lname4", age: 13).save(failOnError: true)
            new Person(firstName: "fname5", lastName: "lname5", age: 14).save(failOnError: true)
            new Person(firstName: "fname6", lastName: "lname6", age: 15).save(failOnError: true)
            new Person(firstName: "fname7", lastName: "lname7", age: 16).save(failOnError: true)
            new Person(firstName: "fname8", lastName: "lname8", age: 17).save(failOnError: true)
            new Person(firstName: "fname9", lastName: "lname9", age: 18).save(failOnError: true)
        }
    }
    def destroy = {
    }
}
