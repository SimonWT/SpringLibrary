$('.form-group').each(function(){
    var $label,
        $input,
        $that = $(this);
        
   

    $label = $that.find('label');
    $input = $that.find('.form-control');


    if($input.val()) {
        $that.addClass('active');
    }

    $input.focus(function(){
        $that.addClass('active');
    });

    $input.blur(function(){
        // console.log($input.val());
        if(!$input.val()) {
            $that.removeClass('active');
        }
    });
});
