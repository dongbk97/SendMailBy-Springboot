package com.controller;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class SendMailController {

    private final JavaMailSender javaMailSender;

    @GetMapping("/send")
    public String sendMail() {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        String content= "\n" +
                "Anh Nguyễn Văn Đồng thân mến,\n" +
                "\n" +
                "Em là Nguyễn Thị Hài - chuyên viên hỗ trợ ứng viên của JobsGO.\n" +
                "\n" +
                "Nhân dịp đầu xuân, năm mới, em xin gửi tới anh lời chúc sức khỏe và thành công.\n" +
                "\n" +
                "Kỳ nghỉ Tết Nguyên đán đã chính thức khép lại, lúc này chính là thời điểm \"vàng\" để anh cập nhật CV và sẵn sàng chào đón những cơ hội việc làm mới. Hiện tại trên JobsGO đang có hàng ngàn công việc hấp dẫn được đăng tải mỗi ngày mà anh không nên bỏ qua để có một năm 2023 thật rực rỡ.\n" +
                "\n" +
                "Anh vui lòng gửi CV/Resume bản mềm mới nhất qua mail này để em hỗ trợ cập nhật thông tin trên JobsGO, qua đó nhận gợi ý việc làm phù hợp và có cơ hội trở thành nhân sự của những công ty hàng đầu.\n" +
                "\n" +
                "Ngoài ra, anh có thể truy cập LINK NÀY để sử dụng công cụ Phân tích CV ứng dụng công nghệ AI của JobsGO. JobsGO AI sẽ tiến hành phân tích dữ liệu; sau đó đưa ra gợi ý các thông tin cần bổ sung, các lỗi chính tả đang tồn tại,... giúp anh có được bản CV tốt nhất và tăng cơ hội lọt vào \"mắt xanh\" các Nhà tuyển dụng.\n" +
                "\n" +
                "Nếu có bất kỳ thắc mắc nào về quá trình đăng tải, cập nhật hồ sơ ứng tuyển, anh có thể liên lạc với em qua email hai.nguyen@jobsgo.vn hoặc SĐT 070.505.2927.\n" +
                "\n" +
                "Cảm ơn và mong sớm nhận được phản hồi từ anh!\n" +
                "\n" +
                "Trân trọng,";
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, false, StandardCharsets.UTF_8.name());
            message.setTo("dongnguyenvan2202@gmail.com");
            message.setSubject("Khởi đầu năm mới với bản CV hoàn hảo");
            message.setText(content);
            javaMailSender.send(mimeMessage);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "Ok";
    }
}
