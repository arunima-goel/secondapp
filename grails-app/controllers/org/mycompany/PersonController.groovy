package org.mycompany

class PersonController {

    def index() {
        def scaffold = Person

        redirect action:"list"
    }

    def list() {
        def personList = Person.list([sort:"lastName", order:"desc"])
        [ personList : personList ]
    }

    def create = {
        [person:new Person()]
    }

    def save() {
        def person = new Person(params)
        if(person.validate() && person.save()) {
            redirect action:"show", id:person.id
        } else {
            render view: "create", model: [person: person]
        }
    }

    def show = {
        withPerson { person ->
            [person:person]
        }
    }

    def edit = {
        withPerson { person ->
            [person:person]
        }
    }

    def update = {
        withPerson { person ->
            person.properties = params
            if(person.validate() && person.save()) {
                redirect action:"show", id:person.id
            } else {
                render view:"edit", model:[person:person]
            }
        }
    }

    def delete = {
        withPerson { person ->
            person.delete()
            redirect action:"list"
        }
    }

    private def withPerson(id="id", Closure c) {
        def person = Person.get(params[id])
        if(person) {
            c.call person
        } else {
            flash.message = "The person was not found."
            redirect action:"list"
        }
    }

}
