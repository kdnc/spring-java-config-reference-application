var contactNewsletterForm = {
     
    ready : function()
    {
        $('input#contactNewsletterFormSubmit').click(
            function(event)
            {
                var input = $(this);

                input.attr('disabled', true);

                if (!contactNewsletterForm.validate())
                {
                    alert("Please provide both your first and last name");

                    input.removeAttr('disabled');

                    event.preventDefault();
                }
                else
                {
                    $('form#contactNewsletterForm').submit();
                }
            }
        );
    },

    validate : function()
    {
        var hasRequiredValues = true;
//        jQuery’s find()method lets you search within the context of a selection.
        $('form#contactNewsletterForm').find('input, select, textarea').each(
//            function provided to each()is executed four times, one for each
//            of the four <input>elements matched in the call to find()
            function()
            {
                var node = $(this);

//            In the context of any jQuery selection, is()tells you whether any of the elements in
//            the selection match a selector that you provide to is(). Another
//            way of asking this question is does the element match the selector: input[required="required"]
//            (if the element is an <input>element, of course).
                if (node.is('[required]'))
                {
                    var value = node.val();

                    if (!value)
                    {
                        hasRequiredValues = false;
                        return false;
                    }
                }
            }
        );

        return hasRequiredValues;
    }        
};

$(document).ready(
    function()
    {
        contactNewsletterForm.ready();
    }
);