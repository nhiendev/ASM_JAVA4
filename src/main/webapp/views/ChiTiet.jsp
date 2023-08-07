<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

  <!-- Bootstrap CSS v5.2.1 -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <link rel="stylesheet" href="/PS24702_NgoNhien_ASM2/css/cssCT.css">



  <section>
    <div class="container-fluid">


      <div class="row " style="margin-top: 20px;">
        <div class="col-md-8">
          <div class="card h-100">
            <iframe width="560" height="315" src="https://www.youtube.com/embed/K0cpoXlHFpQ"
              title="YouTube video player" frameborder="0"
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
              allowfullscreen></iframe>
            <div class="card-body textCard">
              <a >
                <p class="card-title">SÀI GÒN ĐAU LÒNG QUÁ | OFFICIAL MV LYRIC</p>
              </a>
              <div class="accordion accordion-flush " id="accordionFlushExample"
                style="background-color: rgb(207,244,252);">
                <div class="accordion-item">
                  <h2 class="accordion-header" id="flush-headingOne">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                      data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                      Miêu Tả
                    </button>
                  </h2>
                  <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne"
                    data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body">Bật Tình Yêu Lên (Hòa Minzy x Tăng Duy Tân) | Rót mật ngọt vào tai em...
                      Nhạc Chill Gây Nghiện 2023<br>

                      <br> Tracklist: <br> <br>

                      1. Bật Tình Yêu Lên<br>
                      2. Gió<br>
                      3. Là Anh<br>
                      4. Ánh Sao Và Bầu Trời<br>
                      5. Anh Làm Tất Cả Vì<br>
                      6. Anh Đã Từ Bỏ Rồi Đấy<br>
                      7. 11 Giờ 11 Phút<br>
                      8. Rồi Ta Sẽ Ngắm Pháo Hoa Cùng Nhau<br>
                      9. Người Đáng Thương Là Anh <br>
                      10. Ôm Em Lần Cuối <br>
                      11. Kẻ Điên Tin Vào Tình Yêu <br>
                      12. Ôm Trọn Nỗi Nhớ<br>
                      13. Cuối Cùng Thì<br>
                      14. Yêu Anh Đi Mẹ Anh Bán Bánh Mì<br>
                      15. Lý Do Là Gì<br>
                      16. Nếu Em Không Về<br>
                      17. Đổi Hạnh Phúc Lấy Cô Đơn<br>
                      18. Cô Ấy Nói<br>
                      19. Từng Là Của Nhau<br>
                      20. Yêu Nhau Xong Rồi
                    </div>
                  </div>
                </div>


              </div>
            </div>
            
            <div class="card-footer text-end  ">
           		<form action="/PS24702_NgoNhien_ASM2/ChiTiet?dem=false" method="post">
              <button  name="dem" type="submit" class="btn btn-primary ${actip == true ?'active':''}"> <i class="bi-hand-thumbs-up"> Like</i></button>
              <button type="button" class="btn btn-primary"> <i class="bi-share"> Share</i></button>
			</form>

         
            </div>
          </div>
        </div>

        <div class="col-md-4">
          <div class="row">
		<c:forEach var="item" items="${AllPhim}">
            <div class="card mb-3 videoRigh" style="max-width: 540px;">
              <div class="row g-0">
                <div class="col-md-4">
                  <img src="/PS24702_NgoNhien_ASM2/img/${item.poster}" class="img-fluid rounded-start" alt="..."
                    style="width: 150px; height: 80px;">
                </div>
                <div class="col-md-8">

                  <div class="card-body" style=" padding: 0px; margin-left: 10px;">

                    <a href="">
                      <p class="card-text ">${item.title} </p>
                    </a>
                    <small class="text-muted ">Last updated 3 mins ago</small>
                  </div>
                </div>
              </div>
            </div>
	</c:forEach>
            
  

         

          </div>
        </div>
      </div>
    </div>
  </section>

  <footer style="margin-bottom: 0px">
    <div class="container">
        <div class="row ">
            <div class="col-md-6 ts">
                <p class="fonFooter">About Us</p>
                <div class="panel-heading  Template">Copyright &copy; 2023 FPT Polytechnic. Template by Ngô Nhiên</div>
            </div>

            <div class="col-md-3 ts">
                <p class="fonFooter">Follow Us</p>
                <i class="bi bi-facebook"></i>
                <i class="bi bi-github"></i>
                <i class="bi bi-twitter"></i>
                <i class="bi bi-google"></i>
            </div>

            <div class="col-md-2 ts">
                <p class="fonFooter">Tải ngay</p>
                <p><img src="/PS24702_NgoNhien_ASM1/img/img-appstore.jpg" alt=""></p>
                <p><img src="/PS24702_NgoNhien_ASM1/img/img-googleplay.jpg" alt=""></p>
            </div>
        </div>
    </div>
</footer>
  <!-- Bootstrap JavaScript Libraries -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
    integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
    </script>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
    integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
    </script>
</body>

</html>