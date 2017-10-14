package seedu.address.logic.commands;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.ArrayList;

import seedu.address.model.person.ReadOnlyPerson;

/**
 * Sorts all contacts in alphabetical order by their names from the address book.
 * Command is case-insensitive
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";
    public static final String COMMAND_ALIAS = "st";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + " OR "
            + COMMAND_ALIAS
            + ": Sort all contacts names in alphabetical order. ";

    public static final String MESSAGE_SUCCESS = "All contacts are sorted alphabetically by name.";
    public static final String MESSAGE_LIST_EMPTY = "No contacts to be sorted in AddressBook.";

    private ArrayList<ReadOnlyPerson> contactList;

    public SortCommand() {
        contactList = new ArrayList<>();
    }

    @Override
    public CommandResult execute() {
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        Boolean isNotEmpty = model.sortByPersonName(contactList);
        if (isNotEmpty == false) {
            return new CommandResult(MESSAGE_LIST_EMPTY);
        }
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
