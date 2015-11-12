@Items
Feature: created and deleted project's item

  Scenario 1 : delete an item that contain a project.
    Given a project created.
      And creating an Item into the Project.
      And the item that contain the Project  are displayed in today filter
    When the project with the item associated is deleted
      And the item are moved to the recycleBin

  Scenario 2 : Delete the items of the recycle bin
    Given a project created.
      And a subproject is associated into the project
      And an Item is associated into the subproject.
    When the project created is deleted of the subproject
    Then the item is displayed into the recycle bin
      And Recycle Bin is Emptied.
      And there are not any item into Recycle bin.

  Scenario 3 : move an item of the recycle bin to a subproject
    Given an item into the recycle bin
      And a new project is created
      And a subproject is associated to project
    When the item into the recycle bin is dragged and dropped to subproject
    Then the subproject has associated the item
      And the recycle bin is empty

  Scenario 4 : associate an item of Filters Inbox to subproject.
    Given a Item created into the Filters Inbox.
      And a new project is created.
      And a subproject is associated into the project
    When the Item of Filters Inbox is associated to the subproject.
    Then there are not items into the Filters Inbox.
      And the subproject has associated the item.


  Scenario 5 : an item is displayed into the Filters Today
    Given a project created.
     And a subproject is associated into the project
     And an Item is associated into the subproject.
    When the item has a note with date today.
     And the item is displayed into the Filters Today


  Scenario 6 : an item is displayed into the Filters next
    Given a project created.
     And a subproject is associated into the project
     And an Item is associated into the subproject
    When the item has a note with date next day
     And the item is displayed into the Filters Next


  Scenario 7 : Change the subproject icon.
    Given a project created.
      And a subproject is associated into the project
    When the subproject icon is changed
      And the default subproject icon is changed by the new icon

