package org.mycompany

class PersonController {

    def index() {
        def scaffold = Person

        redirect action:"list"
    }

    def list() {
        log.info("List all people")
        def personList = Person.list([sort:"lastName", order:"desc"])
        [ personList : personList ]
    }

    def create = {
        log.error("Create new person")
        [person:new Person()]
    }

    def save() {
        log.error("Save person")
        def person = new Person(params)
        if(person.validate() && person.save()) {
            redirect action:"show", id:person.id
        } else {
            render view: "create", model: [person: person]
        }
    }

    def show = {
        log.error("Show person")
        withPerson { person ->
            [person:person]
        }
    }

    def edit = {
        log.error("Edit person")
        withPerson { person ->
            [person:person]
        }
    }

    def update = {
        log.error("Update person")
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
        log.error("Delete person")
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
