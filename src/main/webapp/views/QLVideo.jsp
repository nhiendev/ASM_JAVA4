<%@ page language="java" contentType="text/html; charset= utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    <style>

</style>
    <section style="margin-top: 20px;">

        <div class="container">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link active" data-bs-toggle="tab" href="#home">Video Edition</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-bs-toggle="tab" href="#menu1">Video List</a>
                </li>

            </ul>
	<c:url var="url" value="/user"/>
            <!-- Tab panes -->
            <div class="tab-content" style="border-top:  1px solid rgb(220, 220, 220);">
                <div class="tab-pane container active mt-4" id="home">
		
			<form action="/editVideo" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="card text-bg-dark">
                                <img src="/PS24702_NgoNhien_ASM2/img/${form.poster}" class="card-img" alt="...">
                                <div class="card-img-overlay">
                                </div>
                            </div>
                            
                            <div class="mb-3">
						  <label for="formFile" class="form-label">Chọn Poster</label>
						  <input class="form-control" value="${form.poster}"  name="poster" type="file" id="formFile">
						</div>
						     </div>
                        <div class="col-sm-8">
                            <label for="text">ID</label> <input name="id" value="${form.id}" id="text" class="form-control" 
                                aria-label="Search">

                            <label for="text">Tiêu Đề</label> <input name="title" value="${form.title}" id="text" class="form-control" 
                                aria-label="Search">

                            <label for="text">Lượt xem </label><input name="views" value="${form.views}" id="text" class="form-control" 
                                aria-label="Search">
                                		<div class="d-flex mt-2 ">
									<div class="form-check mx-3">
											  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" ${form.active?'checked':''}>
											  <label class="form-check-label" for="flexRadioDefault1">
											 Active
											  </label>
											</div>
											<div class="form-check ">
											  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" ${form.active?'':'checked'}>
											  <label class="form-check-label" for="flexRadioDefault2">
											InActive
											  </label>
											</div>
											</div>							
                            <div class="mb-3">
                                <label for="text">Miêu Tả</label>
                                <label for="" class="form-label"></label>
                                <textarea class="form-control"  name="description" id="" rows="3">${form.description} </textarea>
                            </div>
                            
                            
                            <button formaction="${url}/createVideo"  class="btn btn-danger"> <i class="bi bi-node-plus-fill" style="color: white;"> Tạo</i></button>
                            <button  formaction="${url}/updateVideo"  class="btn btn-danger"> <i class="bi bi-pencil-square" style="color: white;"> Chỉnh sửa</i></button>
                            <button formaction="${url}/deleteVideo/${form.id}"  class="btn btn-danger"><i class="bi bi-trash3" style="color: white;"> Xóa</i> </button>
                            <button formaction="/PS24702_NgoNhien_ASM2/manager/QLvideo"  class="btn btn-danger"><i class="bi bi-lightning" style="color: white;"> Tải Lại</i> </button>
                        </div>
                    </div>
                  </form>
                </div>
                <div class="tab-pane container fade" id="menu1">
                    <div class="row col-md-12 col-md-offset-2 custyle">
                    
                        <table class="table table-striped custab">
                        <thead>
                  
                            <tr>
                                <th>ID</th>
                                <th>Tiêu Đề</th>
                                <th>Lượt xem</th>
                                <th class="text-center">Action</th>
                            </tr>
                        </thead>
                           <c:forEach var="item" items="${videoALL}">
                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.title}</td>
                                    <td>${item.views}</td>
                                    <td class="text-center"><a class='btn btn-info btn-xs' href="/PS24702_NgoNhien_ASM2/editVideo/${item.id}"><i class="bi bi-pencil-square"> </i></a> 
                                  
                                </tr>
                                </c:forEach>
                             
                        </table>
                        </div>

                </div>

            </div>
        </div>

    </section>

    