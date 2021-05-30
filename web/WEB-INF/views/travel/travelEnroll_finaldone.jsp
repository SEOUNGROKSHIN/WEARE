<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>without bootstrap</title>
    
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.3.min.js"></script> 
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" />
 
 
 
 
    <link href="/we/resources/summernote/summernote.css" rel="stylesheet">
    <script	src="/we/resources/summernote/summernote.js"></script>
  </head>
  <body>
    <div id="summernote"></div>
    <script>
      $('#summernote').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 120,
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['insert', ['link', 'picture', 'video']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ],
       /*  callbacks: {	 *///여기 부분이 이미지를 첨부하는 부분
        	
        	 onImageUpload: function(files, editor, welEditable) {
        		 for (var i = files.length - 1; i >= 0; i--) {
                      sendFile(files[i], this);
                    }
        	 }

        
        	 
        	/*  onImageUpload: function(e) {
        	      console.log(e); */
			
	/* 		}, */
		/* 	onPaste: function (e) {
				var clipboardData = e.originalEvent.clipboardData;
				if (clipboardData && clipboardData.items && clipboardData.items.length) {
					var item = clipboardData.items[0];
					if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
						e.preventDefault();
					}
				}
			} */
		
      });
      /* function sendFile(file) { */
   		/* console.log("aha");
  		data = new FormData();
  		data.append("file", file);
  		$.ajax({
  			data : data,
  			type : "POST",
  			url : "/summernoteUploadServlet",
  			contentType : false,
  			processData : false,
  			success : function(data, textStatus, xhr) {
              	//항상 업로드된 파일의 url이 있어야 한다.
  				$(editor).summernote('insertImage', data.url);
  			},
  			error: function(xhr, status, error){
  				console.log(status);
  				console.log(error);
  			}
  		}); */
    	 /*  data = new FormData();
          data.append("files", file);
          upload_url = "${ pageContext.servletContext.contextPath }/summernoteUploadServlet";
          $.ajax({
              data: data,
              type: "POST",
              url: upload_url,
              cache: false,
              contentType: false,
              processData: false,
              success: function(url) {
                  editor.insertImage(welEditable, url);
              },
              error: function(xhr, status, error){
            	  cosole.log("asdfasdf");
              }
          	
          }); */
          function sendFile(file, editor, welEditable) {
        	    data = new FormData();
        	    data.append("intro", file);
        	    url = "${ pageContext.servletContext.contextPath}/summernoteUploadServlet";
        	    $.ajax({
        	      data: data,
        	      type: "post",
        	      url: url,
        	      cache: false,
        	      enctype: 'multipart/form-data',
        	      contentType: false,
        	      processData: false,
        	      success: function (data) {
        	    	  
        	    	  $(editor).summernote('editor.insertImage', "../"+ data.url);
        	           /* $('#imageBoard > ul').append('<li><img src="'+"../"+ data.url+'" width="480" height="auto"/></li>'); */
        	      }
        	    });
        	  }
  	
    </script>
  </body>
</html>