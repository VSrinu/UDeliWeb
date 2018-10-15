$.fn.pageMe = function(opts){
    var $this = this,
        defaults = {
            activeColor: 'blue',
            perPage: 1,
            showPrevNext: false,
            nextText: '',
            prevText: '',
            hidePageNumbers: false
        },
        settings = $.extend(defaults, opts);

    var listElement = $this;
    var perPage = settings.perPage;
    var children = listElement.children();
    var pager = $('.pager');

    if (typeof settings.childSelector!="undefined") {
        children = listElement.find(settings.childSelector);
    }

    if (typeof settings.pagerSelector!="undefined") {
        pager = $(settings.pagerSelector);
    }

    var numItems = children.size();
    var numPages = Math.ceil(numItems/perPage);
    
    $("#total_reg").html(numItems+" Entries In Total");

    pager.data("curr",0);

    if (settings.showPrevNext){
        $('<li><a href="#" class="prev_link" title="'+settings.prevText+'"><i class="material-icons">chevron_left</i></a></li>').appendTo(pager);
    }

    var curr = 0;
    while(numPages > curr && (settings.hidePageNumbers==false)){
        $('<li class="waves-effect"><a href="#" class="page_link">'+(curr+1)+'</a></li>').appendTo(pager);
        curr++;
    }

    if (settings.showPrevNext){
        $('<li><a href="#" class="next_link"  title="'+settings.nextText+'"><i class="material-icons">chevron_right</i></a></li>').appendTo(pager);
    }

    pager.find('.page_link:first').addClass('active');
    pager.find('.prev_link').hide();
    if (numPages<=1) {
        pager.find('.next_link').hide();
    }
  	pager.children().eq(1).addClass("active "+settings.activeColor);

    children.hide();
    children.slice(0, perPage).show();

    pager.find('li .page_link').click(function(){
        var clickedPage = $(this).html().valueOf()-1;
        goTo(clickedPage,perPage);
        return false;
    });
    pager.find('li .prev_link').click(function(){
        previous();
        return false;
    });
    pager.find('li .next_link').click(function(){
        next();
        return false;
    });

    function previous(){
        var goToPage = parseInt(pager.data("curr")) - 1;
        goTo(goToPage);
    }

    function next(){
        goToPage = parseInt(pager.data("curr")) + 1;
        goTo(goToPage);
    }

    function goTo(page){
        var startAt = page * perPage,
            endOn = startAt + perPage;

        children.css('display','none').slice(startAt, endOn).show();

        if (page>=1) {
            pager.find('.prev_link').show();
        }
        else {
            pager.find('.prev_link').hide();
        }

        if (page<(numPages-1)) {
            pager.find('.next_link').show();
        }
        else {
            pager.find('.next_link').hide();
        }

        pager.data("curr",page);
      	pager.children().removeClass("active "+settings.activeColor);
        pager.children().eq(page+1).addClass("active "+settings.activeColor);

    }
};


function NewOrdrs()                                    
{ 
    var ordertitle = document.forms["OrderForm"]["ordertitle"];               
    var orderdetails = document.forms["OrderForm"]["orderdetails"];    
    var name = document.forms["OrderForm"]["name"];  
    var phonenumber =  document.forms["OrderForm"]["phonenumber"];  
    var email = document.forms["OrderForm"]["email"];  
    var address = document.forms["OrderForm"]["address"]; 
    var city = document.forms["OrderForm"]["city"];               
    var state = document.forms["OrderForm"]["state"];    
    var zip = document.forms["OrderForm"]["zip"];  
    var bags =  document.forms["OrderForm"]["bags"];  
    var items = document.forms["OrderForm"]["items"];  
    var weight = document.forms["OrderForm"]["weight"];  
    var perishable = document.forms["OrderForm"]["perishable"];               
    var fragile = document.forms["OrderForm"]["fragile"];    
    var deliverytimes = document.forms["OrderForm"]["deliverytimes"];  
   
    if (ordertitle.value == "")                                  
    { 
        window.alert("Please enter ordertitle."); 
        ordertitle.focus(); 
        return false; 
    } 
   
    if (orderdetails.value == "")                               
    { 
        window.alert("Please enter orderdetails."); 
        orderdetails.focus(); 
        return false; 
    } 
    
    if (name.value == "")                               
    { 
        window.alert("Please enter Customer Name."); 
        name.focus(); 
        return false; 
    } 
       
    if (email.value == "")                                   
    { 
        window.alert("Please enter a valid e-mail address."); 
        email.focus(); 
        return false; 
    } 
   
    if (email.value.indexOf("@", 0) < 0)                 
    { 
        window.alert("Please enter a valid e-mail address."); 
        email.focus(); 
        return false; 
    } 
   
    if (email.value.indexOf(".", 0) < 0)                 
    { 
        window.alert("Please enter a valid e-mail address."); 
        email.focus(); 
        return false; 
    } 
   
    if (phonenumber.value == "")                           
    { 
        window.alert("Please enter phonenumber."); 
        phonenumber.focus(); 
        return false; 
    } 
   
    if (address.value == "")                        
    { 
        window.alert("Please enter address"); 
        address.focus(); 
        return flase; 
    } 
    
    if (city.value == "")                        
    { 
        window.alert("Please enter city"); 
        city.focus(); 
        return flase; 
    }
    
    if (state.value == "")                        
    { 
        window.alert("Please enter state"); 
        state.focus(); 
        return flase; 
    }

    if (zip.value == "")                           
    { 
        window.alert("Please enter zip."); 
        zip.focus(); 
        return false; 
    } 
   
    if (bags.value == "")                        
    { 
        window.alert("Please enter Number of bags"); 
        bags.focus(); 
        return flase; 
    } 
    
    if (items.value == "")                        
    { 
        window.alert("Please enter Number of Items"); 
        items.focus(); 
        return flase; 
    }
    
    if (weight.value == "")                        
    { 
        window.alert("Please enter total weight"); 
        weight.focus(); 
        return flase; 
    }
   
    if (perishable.selectedIndex < 1)                  
    { 
        alert("Please select perishable."); 
        perishable.focus(); 
        return false; 
    } 
    
    if (fragile.selectedIndex < 1)                  
    { 
        alert("Please select fragile."); 
        fragile.focus(); 
        return false; 
    } 
    
    if (deliverytimes.value == "")                        
    { 
        window.alert("Please enter delivery date and times"); 
        deliverytimes.focus(); 
        return flase; 
    }
   
    return true; 
}
