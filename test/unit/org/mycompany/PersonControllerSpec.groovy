package org.mycompany

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PersonController)
class PersonControllerSpec extends Specification {

    def setup() {
        new Person(firstName: "UTFirstName", lastName: "UTLastName", age: 10).save(flush: true)
    }

    def cleanup() {
    }

    public void index() {
        when: controller.index()
        then: response.redirectedUrl == '/person/list'
    }


}
/*


    @Test
    public void index() {
        controller.index()
        assert "list" == controller.redirectArgs.action
    }

    @Test
    public void list() {
        def model = controller.list()
        assert 2 == model.people.size()
        assert p7 == model.people[0]
        assert p9 == model.people[1]
        assert 2 == model.count
    }

    @Test
    public void show() {
        controller.params.id = 7
        def model = controller.show()
        assert p7 == model.person
    }

    @Test
    public void create() {
        def model = controller.create()
        assert model.person instanceof Person
    }

    @Test
    public void save_success() {
        controller.params.name = "Paul Woods"
        controller.save()
        assert "show" == controller.redirectArgs.action
        assert null != controller.redirectArgs.id
    }

    @Test
    public void save_failure() {
        controller.params.name = ""
        controller.save()
        assert "create" == controller.renderArgs.view
        assert controller.renderArgs.model.person instanceof Person
    }

    @Test
    public void edit() {
        controller.params.id = 9
        def model = controller.edit()
        assert p9 == model.person
    }

    @Test
    public void update_success() {
        controller.params.name = "Paul Woods"
        controller.params.id = 7
        controller.update()
        assert "show" == controller.redirectArgs.action
        assert 7 == controller.redirectArgs.id
    }

    @Test
    public void update_failure() {
        controller.params.name = ""
        controller.params.id = 9
        controller.update()
        assert "edit" == controller.renderArgs.view
        assert controller.renderArgs.model.person instanceof Person
    }

    @Test
    public void delete() {
        controller.params.id = 7
        controller.delete()
        assert "list" == controller.redirectArgs.action
        assert 1 == Person.count()
    }

    @Test
    public void withPerson_success() {
        controller.params.id = 7
        def person = null
        controller.withPerson() { p ->
            person = p
        }

        assert 7 == person.id
    }

    @Test
    public void withPerson_fail() {
        controller.params.id = 0
        controller.withPerson() { p ->
            assert false
        }
    assert "The person was not found." == controller.flash.message
    assert "list" == controller.redirectArgs.action
   }

 */