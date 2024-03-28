package ait.imagga.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ColorsDto {
    private List<BgrndColorsDto> background_colors;
    private List<FrgndColorsDto> foreground_colors;
    private List<ImgColorsDto> image_colors;
}
