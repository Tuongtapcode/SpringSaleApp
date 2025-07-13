function deleteProduct(endpoint) {
  if (confirm("Bạn chắc chắn xóa?") === true) {
    fetch(endpoint, {
      method: "DELETE",
    }).then((response) => {
      if (response.status == 204) {
        location.reload();
      } else {
        alert("Hệ thống xảy ra lỗi khi xóa product: " + response.statusText);
      }
    });
  }
}
