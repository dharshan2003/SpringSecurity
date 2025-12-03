<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-...">
</head>
<body>
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-..."></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-..."></script>

    <div class="container mt-5">
        <form action="/register" method="post">
            <div class="form-group">
                <label for="formGroupExampleInput" class="form-label">User Name</label>
                <input type="text" class="form-control" id="formGroupExampleInput"
                       placeholder="Enter User Name" name="username">
            </div>
            <div class="mb-3">
                <label for="formGroupExampleInput2" class="form-label">E Mail</label>
                <input type="text" class="form-control" id="formGroupExampleInput2"
                       placeholder="Enter Email" name="email">
            </div>
            <div class="container text-center">
                <button type="submit" class="btn btn-success">sign up</button>
            </div>
        </form>
    </div>
</body>
</html>