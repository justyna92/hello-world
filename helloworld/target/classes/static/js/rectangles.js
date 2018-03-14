function startGame() {
	
    myGameArea.start();
    
    for(i=0; i<=window.innerWidth; i=i+40){
    	myarray.push(new component(30, 30, '#'+(0x1000000+(Math.random())*0xffffff).toString(16).substr(1,6), i, 0));
    	myarray2.push(new component(30, 30, '#'+(0x1000000+(Math.random())*0xffffff).toString(16).substr(1,6), i, 50));
    	myarray3.push(new component(30, 30, '#'+(0x1000000+(Math.random())*0xffffff).toString(16).substr(1,6), i, 100));
    }
    
    console.log(myarray.length);
    console.log(window.innerWidth);
    console.log(window.innerHeight);
    
}

var myarray = [];
var myarray2 = [];
var myarray3 = [];

var myGameArea = {
    canvas : document.createElement("canvas"),
    start : function() {
        this.canvas.width = window.innerWidth;
        this.canvas.height = window.innerHeight;
        this.context = this.canvas.getContext("2d");
        document.body.insertBefore(this.canvas, document.body.childNodes[0]);
        this.interval = setInterval(updateGameArea, 15);
    },
    clear : function() {
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);  
    }
}

function component(width, height, color, x, y) {
	
    this.width = width;
    this.height = height;
    this.x = x;
    this.y = y;
    this.update = function(){
      ctx = myGameArea.context;
      ctx.fillStyle = color;
      ctx.fillRect(this.x, this.y, this.width, this.height);
    }
}

var flag = 0;

function updateGameArea() {
	
    myGameArea.clear();

    for(i=0; i<myarray.length; i++){
    	if(myarray3[i].y == window.innerHeight) {
    		flag = 1;
    	} else if(myarray[i].y == 0) {
    		flag = 0;
    	}
    	if(flag == 1){
	    	myarray[i].y -= 1;
	    	myarray2[i].y -= 1;
	    	myarray3[i].y -= 1;
    	} else {
    		myarray[i].y += 1;
        	myarray2[i].y += 1;
        	myarray3[i].y += 1;
    	}
    }

    for(i=0; i<myarray.length; i++){
    	myarray[i].update();
    	myarray2[i].update();
    	myarray3[i].update();
    }
}